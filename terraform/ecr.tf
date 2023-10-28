resource "aws_ecr_repository" "cpb_backend_repo" {
  name                 = "capibytes-backend-repo"
  image_tag_mutability = "MUTABLE"
  image_scanning_configuration {
    scan_on_push = false
  }
}
