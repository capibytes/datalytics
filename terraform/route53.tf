resource "aws_route53_record" "api_validation" {
  for_each = {
    for dvo in aws_acm_certificate.api_cert.domain_validation_options : dvo.domain_name => {
      name   = dvo.resource_record_name
      record = dvo.resource_record_value
      type   = dvo.resource_record_type
    }
  }

  name    = each.value.name
  type    = each.value.type
  zone_id = "YOUR_ZONE_ID"  # Replace with your Zone ID
  records = [each.value.record]
  ttl     = 60
}

resource "aws_route53_record" "api" {
  name    = "api.datalytics.devs2blu.dev.br"
  type    = "A"
  zone_id = "YOUR_ZONE_ID"  # Replace with your Zone ID
  alias {
    name                   = aws_lb.cpb_alb.dns_name
    zone_id                = aws_lb.cpb_alb.zone_id
    evaluate_target_health = true
  }
}
