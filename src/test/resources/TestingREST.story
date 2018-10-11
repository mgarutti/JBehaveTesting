Meta:

Narrative:
As a user
I want to verify the response of a REST API
So that I can make sure that the service works

Scenario: Test the response of the Countries API
Given I send a request to the API
When I check if status code is 200
Then the response must have the value 170

Scenario: Test the positive response of a Mocky endpoint
Given I search for the food banana
When I check if the status code is 200
Then the response must have the value food_b0bn6w4ab49t55b1o8jsnbq6nm2g