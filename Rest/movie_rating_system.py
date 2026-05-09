from datetime import datetime

now = datetime.now()
def create_dictionary_to_store_movies():
    return {}


def add_movie_to_collection(movie_collection, movie_name):
    if not movie_name:
        return "Movie name cannot be empty."

    existing_movies = [name.lower() for name in movie_collection]
    if movie_name.lower() in existing_movies:
        return f"'{movie_name}' already exists."

    movie_collection[movie_name] = []
    return f"'{movie_name}' added successfully."


def rate_movie(movie_collection, entered_movie_name, rating_input):
    if not movie_collection:
        return "No movies available. Please add a movie first."

    available_movies = list(movie_collection.keys())

    matched_movie_name = next(
        (title for title in available_movies if title.lower() == entered_movie_name.lower()),
        None
    )

    if not matched_movie_name:
        return f"Movie '{entered_movie_name}' not found."

    try:
        user_rating = float(rating_input)

        if not (1.0 <= user_rating <= 5.0):
            return "Rating must be between 1.0 and 5.0."

        movie_collection[matched_movie_name].append(user_rating)
        return f"Rated '{matched_movie_name}' with {user_rating:.1f}/10."

    except ValueError:
        return "Invalid input. Please enter a numeric rating."


def view_average_ratings(movie_collection):
    if not movie_collection:
        return {}

    averages = {}

    for movie_name, ratings in movie_collection.items():
        if ratings:
            averages[movie_name] = round(sum(ratings) / len(ratings), 2)
        else:
            averages[movie_name] = None

    return averages


def main():
    print("Welcome to Movie Rating System")
    now = datetime.now()
    print("Current date & time:", now.strftime("%d-%m-%Y %H:%M:%S"))

    name = input("Enter your name: ")
    print(name, "welcome to the Movie Rating System")

    movie_collection = create_dictionary_to_store_movies()

    while True:
        print("\n1. Add a Movie")
        print("2. Rate a Movie")
        print("3. View average ratings")
        print("4. Exit")

        choice = input("Enter your choice: ")

        if choice == "1":
            movie_name = input("Enter movie name: ")
            print(add_movie_to_collection(movie_collection, movie_name))

        elif choice == "2":
            movie_name = input("Enter movie name: ")
            rating = input("Enter rating (1.0 - 10.0): ")
            print(rate_movie(movie_collection, movie_name, rating))

        elif choice == "3":
            averages = view_average_ratings(movie_collection)
            if not averages:
                print("No movies available.")
            else:
                for movie, average in averages.items():
                    if average is None:
                        print(f"{movie}: No ratings yet")
                    else:
                        print(f"{movie}: {average:.2f}/10")

        elif choice == "4":
            print("Goodbye! Thanks for using the Movie Rating System.")
            break

        else:
            print("Invalid choice. Please enter a number between 1 and 4.")

main()


