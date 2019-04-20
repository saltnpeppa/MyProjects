from urllib.request import urlopen
import json
import reverse_geocoder as rg
from geopy.geocoders import Nominatim
import speech_recognition as sr

# This app will take in user input (speech) and will find the current weather for that place

def reverseGeocode(coordinates):
    result = rg.search(coordinates)
    # result is a list containing ordered dictionary.
    result2 = dict(result[0])
    name = result2['name']
    return name


if __name__ == "__main__":
    r = sr.Recognizer()
    mic = sr.Microphone(1)

    geolocator = Nominatim(user_agent="MyWeatherApp")
    starting_url = "https://api.darksky.net/forecast/02805d038c8a8871eb9b26f73df05daa/"
    next_url = ","

    with mic as source:
        print("What place do you want to get the weather for?")
        translate = r.listen(source)

    place = r.recognize_google(translate)
    location = geolocator.geocode(place)

    latitude = location.latitude
    longitude = location.longitude

    actual_url = starting_url + str(latitude) + next_url + str(longitude)

    obj = urlopen(actual_url)

    data = json.load(obj)

    print("The temperature is " + str(data['currently']['temperature']) + " degrees fahrenheit in " + place)
    print("The status is: " + data['currently']['summary'])
