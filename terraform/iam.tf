resource "aws_iam_policy" "backend_ecr_pull" {
  name        = "CapibytesBackendECRPullPolicy"
  description = "Permite instancia fazer pull no ECR backend CapiBytes"

  policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Effect    = "Allow",
        Action    = ["ecr:GetDownloadUrlForLayer", "ecr:BatchGetImage", "ecr:BatchCheckLayerAvailability"],
        Resource  = [aws_ecr_repository.cpb_backend_repo.arn]
      }
    ]
  })
}

resource "aws_iam_role" "backend_ec2_role" {
  name = "CapibytesBackendEC2RoleForECR"

  assume_role_policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Action = "sts:AssumeRole",
        Effect = "Allow",
        Principal = {
          Service = "ec2.amazonaws.com"
        }
      }
    ]
  })
}


resource "aws_iam_role_policy_attachment" "backend_ecr_pull_attach" {
  role       = aws_iam_role.backend_ec2_role.name
  policy_arn = aws_iam_policy.backend_ecr_pull.arn
}

resource "aws_iam_instance_profile" "backend_ec2_profile" {
  name = "CapibytesBackendEC2ProfileForECR"
  role = aws_iam_role.backend_ec2_role.name
}