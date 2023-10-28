resource "aws_db_instance" "cpb_rds" {
  allocated_storage    = 100  # Change this based on your needs
  storage_type         = "gp2"
  engine               = "postgres"
  engine_version       = "15.4"
  instance_class       = "db.t3.micro"
  db_name              = local.app_name
  username             = var.db_username
  password             = var.db_password
  skip_final_snapshot  = true
  identifier = "capibytes-db"

  # Open to external connections (not recommended for production)
  publicly_accessible = true

  vpc_security_group_ids = [aws_security_group.rds_sg.id]
  db_subnet_group_name   = aws_db_subnet_group.rds_subnet_group.name

  tags = {
    Name = "capibytes-db"
  }
}

resource "aws_security_group" "rds_sg" {
  name        = "capibytes_rds_sg"
  description = "Allow all inbound traffic to PostgreSQL"
  vpc_id      = aws_vpc.cpb_vpc.id

  ingress {
    from_port   = 5432
    to_port     = 5432
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # Allows connection from anywhere
  }

  ingress {
    from_port   = 5432
    to_port     = 5432
    protocol    = "tcp"
    security_groups = [aws_security_group.ec2_sg.id]
  }
}

resource "aws_db_subnet_group" "rds_subnet_group" {
  name       = "capibytes_rds_subnet_group"
  subnet_ids = [aws_subnet.cpb_subnet1.id, aws_subnet.cpb_subnet2.id]
}