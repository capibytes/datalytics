resource "aws_lb" "cpb_alb" {
  name               = "capibytes-alb"
  internal           = false
  load_balancer_type = "application"
  security_groups    = [aws_security_group.alb_sg.id]
  subnets            = [aws_subnet.cpb_subnet1.id, aws_subnet.cpb_subnet2.id]
  enable_deletion_protection = false

  enable_http2 = true
  idle_timeout = 60
}

resource "aws_security_group" "alb_sg" {
  name        = "capibytes-alb-sg"
  description = "Permite todo tráfego de entrada"
  vpc_id      = aws_vpc.cpb_vpc.id

  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_lb_target_group" "cpb_alb_tg" {
  name     = "capibytes-backend-tg"
  port     = local.backend_port
  protocol = "HTTP"
  vpc_id   = aws_vpc.cpb_vpc.id

  health_check {
    enabled             = true
    interval            = 30
    path                = "/"
    port                = "80"
    protocol            = "HTTP"
    timeout             = 5
    unhealthy_threshold = 2
    healthy_threshold   = 2
  }
}

resource "aws_lb_listener" "alb_http_listener" {
  load_balancer_arn = aws_lb.cpb_alb.arn
  port              = "80"
  protocol          = "HTTP"

  default_action {
    type = "redirect"
    redirect {
      port        = "443"
      protocol    = "HTTPS"
      status_code = "HTTP_301"
    }
  }
}

resource "aws_lb_listener" "https_listener" {
  load_balancer_arn = aws_lb.cpb_alb.arn
  port              = "443"
  protocol          = "HTTPS"
  ssl_policy        = "ELBSecurityPolicy-2016-08"
  certificate_arn   = aws_acm_certificate.api_cert.arn

  default_action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.cpb_alb_tg.arn
  }
}

resource "aws_lb_target_group_attachment" "cpb_ec2_tg_attach" {
  target_group_arn = aws_lb_target_group.cpb_alb_tg.arn
  target_id        = aws_instance.cpb_ec2.id
  port             = local.backend_port
}
