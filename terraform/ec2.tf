resource "aws_security_group" "ec2_sg" {
  name        = "capibytes_ec2_sg"
  description = "Security group for EC2 instance"
  vpc_id      = aws_vpc.cpb_vpc.id

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]  # Warning: This allows SSH access from anywhere!
  }

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  # Permite conexão a partir do load balancer. Útil para quando bloquearmos acesso público ao backend.
  ingress {
    from_port   = local.backend_port
    to_port     = local.backend_port
    protocol    = "tcp"
    security_groups = [aws_security_group.alb_sg.id]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]  # Allow all outbound traffic
  }
}

resource "aws_instance" "cpb_ec2" {
  ami           = local.ami_ubuntu  # Ubuntu 22.04
  instance_type = "t3.medium"

  key_name               = "capibytes-cecilia"  # Specify your key pair name if you have one
  vpc_security_group_ids = [aws_security_group.ec2_sg.id]
  subnet_id              = aws_subnet.cpb_subnet1.id
  iam_instance_profile = aws_iam_instance_profile.backend_ec2_profile.name

  tags = {
    Name = "capibytes_ec2"
  }
}
