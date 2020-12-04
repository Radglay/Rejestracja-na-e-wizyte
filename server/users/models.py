from django.db import models
from django.contrib.auth.models import User



class UserProfile(models.Model):
	user = models.OneToOneField(User, on_delete=models.CASCADE)

	
	nazwisko = models.CharField(max_length = 50)
	pesel = models.CharField(max_length = 11)#, min_length = 11, regex=r'^[\d-]+$', required = True)#  validators=[RegexValidator(r'^\d{1,10}$')])^[0-9]*$
	telefon = models.CharField(max_length = 9)#, min_length = 9, regex=r'^[\d-]+$', required = True)

	def __str__(self):
		return self.user.username