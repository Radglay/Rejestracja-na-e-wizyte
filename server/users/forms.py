from django import forms
from django.contrib.auth.models import User
from django.contrib.auth.forms import UserCreationForm
from django.core.validators import RegexValidator
from .models import UserProfile



class UserRegisterForm(UserCreationForm):
	email = forms.EmailField()
	first_name= forms.CharField()
	last_name = forms.CharField()
	class Meta:
		model = User
		fields = ['username', 'email', 'first_name', 'last_name', 'password1', 'password2']


class UserProfileForm(forms.ModelForm):
	pesel = forms.RegexField(max_length = 11, min_length = 11, regex=r'^[\d-]+$', required = True)#  validators=[RegexValidator(r'^\d{1,10}$')])^[0-9]*$
	telefon = forms.RegexField(max_length = 9, min_length = 9, regex=r'^[\d-]+$', required = True)
	class Meta:
		model = UserProfile 
		fields = ['nazwisko', 'pesel', 'telefon']





