# Eongaku
Eongaku is a android application that plays music based on emotion detection
-------------------------------------------------------------------------------------------------------------

The app uses Deep learning in order to detect a persons 
emotion and plays music accordingly.The app is at its early 
state and focuses on improving the music recomendaation algorithms.
It tries to create a very emotional and personal experience for the user.

-------------------------------------------------------------------------------------------------------------
Requirements to run the code
------------------------------------------------------------------------------------------------------------
  ImagePicker library for kotlin and java
  
  A Tensor Flow Lite Model for classification, 
  Checkout my Emotion-Detection-model repository.
  
-------------------------------------------------------------------------------------------------------------

The model in the app has used a CNN algorithm on 
FER-2013 dataset that is giving us a accuracy of 63.2%,
It classifies the image into four moods Fear, Happy, Neutral, 
Sad and plays music accordingly.
