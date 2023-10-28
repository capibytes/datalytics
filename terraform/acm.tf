resource "aws_acm_certificate" "api_cert" {
  domain_name       = "api.datalytics.devs2blu.dev.br"
  validation_method = "DNS"

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_acm_certificate_validation" "cert_validation" {
  certificate_arn         = aws_acm_certificate.api_cert.arn
  validation_record_fqdns = [for record in aws_acm_certificate.api_cert.domain_validation_options : record.resource_record_name]
}