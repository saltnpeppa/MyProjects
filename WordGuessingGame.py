import random
import speech_recognition as sr
import time

# This program will give you a clue for a word, and then it will require you to say what you think the word is

print("Today we will be playing a word guessing game!")
time.sleep(3)

words = ["biology", "chemistry", "mechanics", "magnetism", "optics", "nuclear physics", "anatomy"]

chosenWord = random.choice(words).lower()

if chosenWord == "biology":
    print("This subject is the general study of living things")

elif chosenWord == "chemistry":
    print("This subject is the study of chemical reactions")

elif chosenWord == "mechanics":
    print("This subject is the physics of mechanical systems")

elif chosenWord == "magnetism":
    print("This subject is the physics of magnets")

elif chosenWord == "optics":
    print("This subject is the physics of light")

elif chosenWord == "nuclear physics":
    print("This subject is the physics of nuclear reactions")

elif chosenWord == "anatomy":
    print("This subject is the study of the human body")

mic = sr.Microphone(1)
r = sr.Recognizer()

with mic as source:
    transcribe = r.listen(source)

speaking = r.recognize_google(transcribe)

if speaking.lower() == chosenWord:
    print("Correct!")

else:
    print("Wrong!")

print(speaking)
