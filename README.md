# A2019 Template Package
_ Template Package for A2019.10 with examples of various input and output types_

## Features
 * Generates single JAR file package that is importable in to an A2019 Control Room.
 * Existing Classes show examples of:
    * Input type: String, 
	* Input type: Number, 
	* Input type: Boolean, 
	* Input type: File, 
	* Input type: Checkbox,
	* Input type: Drop Down Options
	* Input type: Credentials
	* Input type: Radio Buttons
	* Input type: Code
	* Output type: Dictionary
	* Output type: List	
	* Output type: Boolean
    
    
### Building
##### ALL dependencies needed for building the JAR are included in the package.
1. Clone repo into IntelliJ.
2. Run `gradlew assemble` to generate the package.json.
3. Run `gradlew shadowJar` to create the importable fat JAR within the build>libs directory.



## FAQ
### How do I use this?
1. Follow Building instructions above.

2. Import the generated JAR into your A2019 CR-
    1. Log in with a CR Admin account.
    2. Go to Bots>Packages.
    3. Click on "Add a Package" in the upper right corner.
    4. Browse to the generated JAR.
    5. Click "Upload Package." 
    6. Click "Accept, enable and set as default."

