from django.shortcuts import render, redirect
from django.contrib import messages
from .forms import UserRegisterForm, UserProfileForm
from django.contrib.auth.decorators import login_required


def register(request):
	if request.method == 'POST':
		form = UserRegisterForm(request.POST)
		profile_form = UserProfileForm(request.POST)
		if form.is_valid() and profile_form.is_valid():
			user = form.save()

			profile = profile_form.save(commit=False)
			profile.user = user;

			profile.save()

			username = form.cleaned_data.get('username')
			messages.success(request, f'Twoje konto zostało stworzone!')
			return redirect('login')
	else:
		form = UserRegisterForm()
		profile_form = UserProfileForm()

	context = {'form' : form , 'profile_form' : profile_form}
	return render(request, 'users/register.html', context)


@login_required
def profile(request):
	return render(request, 'users/Karta Pacjenta.html')

