resource "aws_vpc" "cpb_vpc" {
  cidr_block = "10.0.0.0/16"
  enable_dns_support   = true
  enable_dns_hostnames = true
  tags = {
    Name = "capibytes_vpc"
  }
}

resource "aws_subnet" "cpb_subnet1" {
  vpc_id     = aws_vpc.cpb_vpc.id
  cidr_block = "10.0.1.0/24"
  availability_zone = "us-east-1a"
  map_public_ip_on_launch = true
  tags = {
    Name = "capibytes_subnet1"
  }
} 

resource "aws_subnet" "cpb_subnet2" {
  vpc_id     = aws_vpc.cpb_vpc.id
  cidr_block = "10.0.2.0/24"
  availability_zone = "us-east-1b"
  map_public_ip_on_launch = true
  tags = {
    Name = "capibytes_subnet2"
  }
} 

resource "aws_internet_gateway" "cpb_igw" {
  vpc_id = aws_vpc.cpb_vpc.id

  tags = {
    Name = "capibytes_igw"
  }
}

resource "aws_route_table" "rt" {
  vpc_id = aws_vpc.cpb_vpc.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.cpb_igw.id
  }

  tags = {
    Name = "route table"
  }
}

resource "aws_route_table_association" "rt1" {
  subnet_id      = aws_subnet.cpb_subnet1.id
  route_table_id = aws_route_table.rt.id
}

resource "aws_route_table_association" "rt2" {
  subnet_id      = aws_subnet.cpb_subnet2.id
  route_table_id = aws_route_table.rt.id
}