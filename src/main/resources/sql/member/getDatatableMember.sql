select
	m.user_id userId,
	m.username username,
	m.password password,
	m.full_name fullName,
	m.phone_number phoneNumber,
	m.email email,
	m.identity_card identityCard,
	m.date_of_birth dateOfBirth,
	m.address address,
	m.role_code roleCode,
	m.status status
from
	member m
where
	1 = 1