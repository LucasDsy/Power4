# project name
TARGETS = Power4

BIN = ./target
MAIN_CLASS = App


#########
# Rules #
#########

# ALL
all : clean build run

# CLEAN
clean :
	@echo
	@echo Cleaning : object files
	@echo --------
	@echo
	rm -Rf ${BIN}/*

# BUILD
build :
	@echo
	@echo Building project
	@echo --------
	@echo
	mvn package

# RUN
run :
	@echo
	@echo Run main file
	@echo --------
	@echo
	java -cp target/Power4-1.0-SNAPSHOT.jar app.App



