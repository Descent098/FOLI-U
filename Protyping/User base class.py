print("Welcome to Foli-U please enter your information\n")

class user:
    """ The base class for user profiles"""
    def __init__(self):
        """Constructor for the class"""
        self.name = ("John Doe")
        print(("Enter Name: John Doe\n"))
        self.program_year = input("What year of your program are you in?: ")
        self.degree = input ("\nWhat is your degree?: ")
    def print_Vars(self):
        """Method to print the user attributes of the current instance"""
        print('')
        print(self.name)
        print('')
        print(self.program_year)
        print('')
        print(self.degree)
    def search_User(username):
        """Method to search for a specific user"""
        print(username)



def main():
    JohnDoe = user()
    JohnDoe.print_Vars()
    user.search_User(input("\nWho do you want to find?: "))
    print('')
    print("Kieran Wood")
    print('')
    print("One")
    print('')
    print("Open Studies")

main()
