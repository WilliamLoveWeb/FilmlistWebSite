#############################################################################

Film list is a web site that list different films with their title, their poster and the average marks
									that viewers attribute to film.

#############################################################################

For launching this web site, you should open the project in development environment.
Then you should go in the repositories "src/main/java" then in the repositories "com.website.filmlist",
you can find a file named "FilmlistApplication.java". After, you right click and push on "run as" and then
on "Spring boot App". 

#############################################################################

In the project we have three main repositories:
	*"src/main/java": java class are mapped in this repositories
		* "com/website/filmlist/":
			*"FilmlistApplication.java": class for launching web application.
			*"config": classes that takes care of Mvc and database configuration
			*"controller": class that take care of controller
			*"dao": class that give the data of database
			*"domain": class that give the form of model data.
			*"repository": class that create a list of model data and use this data.
			*"service": classes that use the class in dao and repository for been used in controller.
	*"src/main/ressources"
		*"application.properties": file contains useful properties.
		*"templates": html files of site.
	*"/src/test/java":test main class of our project. 