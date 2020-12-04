from django.urls import path
from . import views

urlpatterns = [
	path('', views.home, name='strona-home'),
	path('about/', views.about, name='strona-about'),
]