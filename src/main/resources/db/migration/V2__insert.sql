INSERT INTO person (dtype, id, cpf, email, name, about, links, specialization)
VALUES
  ('Consultant', 1, '123456789', 'consultant@example.com', 'Consultant 1', 'About consultant 1', ARRAY['link1', 'link2'], 'Specialization 1'),
  ('Consultant', 2, '987654321', 'consultant2@example.com', 'Consultant 2', 'About consultant 2', ARRAY['link3', 'link4'], 'Specialization 2');

INSERT INTO contact (data_contact, description, title, consultant_id, customer_id)
VALUES
  ('2023-10-01', 'Description 1', 'Title 1', 1, 2),
  ('2023-10-02', 'Description 2', 'Title 2', 2, 1);

INSERT INTO profiles (person_id, profiles)
VALUES
  (1, 1),
  (2, 2);
