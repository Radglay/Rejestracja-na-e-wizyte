from django.shortcuts import render
from .models import Post


def home(request):
	context= {
		'posts': Post.objects.all()
	}
	return render(request, 'strona/home.html', context)    #HttpResponse('<h1>Strona Home</h1>')


def about(request):
	return render(request, 'strona/about.html', {'title': 'About'})


