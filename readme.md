# Automation Tools GBF

## Table of Contents

- [Automation Tools GBF](#automation-tools-gbf)
  - [Table of Contents](#table-of-contents)
  - [Description](#description)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Usage](#usage)
  - [Notes](#notes)
    - [Troubleshooting](#troubleshooting)

## Description

This is my personal Automation tool for [Granblue Fantasy](http://game.granbluefantasy.jp) web browser game.

## Prerequisites

- Windows
- JRE 8 or higher
- JDK 18 or higher
- VSCode or any IDE that can run Java files.

## Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/Faiznurfaza/automation-tools-gbf.git
   cd automation-tools-gbf
   ```

2. Build the project using Maven:
   ```sh
   ./mvnw clean install
   ```

## Usage

To use this automation tool:

1. Open a file from `src/main/java/FreeQuest` or `src/main/java/Raid`
2. For example, if you open `Event.java`, you might see something like this :
   ![ImagePath.GWQuest150](images/Example_1.png)
   the `GWQuest150` image should look like this :
   ![GWQuest150](images/Example_2.png)
3. Add a bookmark bar in your browser tab. Press `CTRL+SHIFT+B` in Chrome to show the bookmark bar:
   ![Bookmark bar](images/Example_2.png)
4. Zoom in the browser to 150% and minimize until it looks like this
   ![Zoom 150%](images/Example_3.png)
   ![Final looks](images/Example_4.png)
5. In your IDE, run the Java file and let the program automate the task for you.
6. To stop it, just force click your mouse to your VScode (if using vscode) and press `SHIFT+F5`.

## Notes

- In some files, the program will run endlessly until a captcha appears.
- Some will run until a specified number of repetitions.
- You need to adjust the code to fit your farm setup. For example, in `src\main\java\Raid\Akasha.java`, I'm using a 2-turn FA Refresh setup.
- Don't forget to: Turn off live battle feed, and turn on one-touch pre-battle auto attack.
- If you already ran the program but your mouse didn't click anything, try this:
  1. Check the file name in this folder `src\main\resources\images`, and make sure it's the same as in the original repository.
  2. Try zooming the browser to 150%.
  3. Re-screenshot the image.

### Troubleshooting

- **Mouse not clicking**: Ensure the image paths are correct and the browser zoom is set to 150%.
- **Program not stopping**: Force click your mouse to your IDE and press `SHIFT+F5`.
- **Image not found**: Re-screenshot the image and replace the existing one in the `src/main/resources/images` folder.
