# project name
TARGETS = Power4

MAIN_CLASS = App

#########
# Rules #
#########

# ALL
all : clean run

# CLEAN
clean :
	@echo
	@echo Cleaning : object files
	@echo --------
	@echo
	mvn clean

# RUN
run :
	@echo
	@echo Run main file
	@echo --------
	@echo
	mvn javafx:run



