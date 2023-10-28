variable "db_username" {
  description = "Username for the database"
  type = string
  sensitive = true
}

variable "db_password" {
  description = "Password for the database"
  type = string
  sensitive = true
}

variable "TFC_AWS_PROVIDER_AUTH" {
  description = "Config para usar OIDC para se autenticar com AWS"
}

variable "TFC_AWS_RUN_ROLE_ARN" {
  description = "ARN da role de acesso AWS"
}

locals {
  region = "us-east-1"
  app_name = "datalytics"
  team_name = "CapiBytes"
  env = "dev"
  ami_ubuntu = "ami-0fc5d935ebf8bc3bc"
  backend_port = 80
  devs2blu_zone_id = "Z046211627S38YQSML8YQ"
  dominio = "datalytics.devs2blu.dev.br"
  }