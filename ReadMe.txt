____ZenGarden____

ZenGarden is a relaxing time waster game where the objective is to pick up all the plants on the map in the shortest time possible.

The aim of the game is to pick all the flowers in your zen garden in the fastest time.

You can make use of characters roaming around your map to help you but first you need to talk to them.

To talk to them simply move into them. Once you talk to them they will change skin and start following you.

Your pesky neighbour is always following you and will always be around if you chose to include NPC's (Non-playable characters).

Once you talk to characters you can either tell them to follow you (press right-shift), avoid you (press left-shift), find a flower (enter), or you can let them go back to what they were doing (spacebar).

NPC's will either find a flower or pick it for you, depending on their mood. Once they find/pick it they will wait until you give them another instruction.

If you find yourself trapped by the characters ordering them away with either left-shift, spacebar or enter.

You can specify how big you want your garden to be and how many characters you want roaming around.

Once you've picked all the flowers you'll be shown how long you took, how many flowers you've picked and the average time per flower.


Features (Difficulty ~approximate time):
	1) Creative visual effects(Very Hard ~8 Hours):
		Smooth animation of the camera frame and main character, as well as plants
		Animation of NPC's
		Layered rendering: The player is able to move infront or behind NPC's or objects such as the house or trees based on their position on the screen and the position of the object. (Move player behind house to see it in action)
		Each character (9 in total) has its own sprite and animation and each NPC has an alternate skin which it switches to when touched. This results in 16 different sprite sheets for NPC's with 8 frames each and the player has a sprite sheet with 16 frames. The plant animation consists of 3 frames. In total the animation made use of 147 different frames.

	
	2) Map
		a) Enhanced grid(Not that hard ~2 Hours):
			The integer grid map has been replaced by a Tile grid( Tile[][]) as a map where each Tile has an x and y coordinate, a tiletype(to determine its texture), an object and an entity
		b) Random map generation(Easy ~1 Hour):
			The placement of flowers and the texture of grass is randomized at the time of creation and adjusts placement so that two objects arent placed at the same coordinate.
		
		c) Camera coordination(Hard ~3 Hours):
			Mapping real world coordinates to player and camera coordinates while maintaining smooth transition

	3) Gameplay
		a) Extensive NPC AI(Hard ~5 Hours):
			Each NPC has a different form of AI. The different implementations are:
				1) Bresenham chase (with obstacle evaision) - This implementation uses bressenham's shortest path algorithm to provide a list of movements that the NPC must follow. If it runs into an obstacle it will try and evade it by skipping a failed move and retrying it or moving in another direction and then retrying the failed move.
				2) Avoid - Simply inverts the movements of the chase algorithm
				3) King - Moves up, down, left and right in sequence. Skips a move if the move fails.
				4)Rook - Moves in one plane at a time only and switches direction if it runs into an obstacle
				5) Knight - Moves in an L shape: 4 movements in one direction and 2 in a direction at 90 degrees.
				6) Random - Moves in an arbitrary direction

		b) Complex gameplay model(Moderately Hard ~4 Hours) - The user has control over the NPC's but only once the user "tags" the NPC. The NPC then changes skin and can be used to follow or evade the player, or chase flowers for the player. Alternatively the player can free the NPC to its original AI. The NPC however can only pick flowers once the player collides with it. (The idea is that the player asks the NPC's to help, modeled by coming into contact with them). Once all the flowers are collected the game notifies the user and provides a score.

		c) Scoring system(Easy ~1.5 Hours) - The game times how long the player has been playing for and, once the game is over, provides the user with the total time, flowers picked and average time per flower.	

		d) Background music(Easy ~0.5 Hours) - Peaceful background music to match the zen tone plays in the background
		e) User customization (Easy ~1 Hour) - The user can customize the size of the map and the number of helper NPC's
		f) Help dialog boxes(Easy ~0.25 Hours) - Gives the user information on how to play the game.

To Run:

Requires Gradle

Go to desktop/build/libs/ and double click on the jar file.

Alternatively:

Unix based OS: ./gradlew desktop:run

Windows: gradlew.bat desktop:run

To Build:

Requires Gradle
Unix based OS: ./gradlew desktop:dist

Windows: gradlew.bat desktop:dist

The built .jar file will be in desktop/build/libs/

To run it after build, change to the above directory and run: java -jar desktop-1.0.jar



		
