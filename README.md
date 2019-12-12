# SkipfishGUI-1.5
**Graphic User Interface for Skipfish Web Application Security Scanner (by lcamtuf)**

You can find the lcamtuf's tool here (although you probably already knew it):
- https://code.google.com/archive/p/skipfish/
- https://github.com/spinkham/skipfish

This is the second release of this project, I'll be updating this repo monthly. Bellow you'll find a list with some characteristics of the GUI:
- You can run multiple scans with basic options.
- Administrative options to manage multiple successive scans through IDs, with easy manipulation of directories.
- Easily set output and input dictionaries.
- Some authentication options: cookies and authentication header.
- **All the performance options easily set through check-box controls.
- Buttons to:
  - Execute scan
  - Show command line: input and output
  - Stop scan
- Easily access to generated report through links that open the report file in the default web browser.
- Input field for the URL or file.
- User input validation and error handling.
- The GUI was carefully built with Java Swing so it's highly maintainable and scalable. More versions ahead.

## Features pending for next releases:
- Some authentication options.
- All of the crawl and scope options.
- most of the reporting options
- Some of the dictionary management options.
- /-k option
- Multiple parallel scans in a single instance. For now you need to open multiple instances for parallel scans, but you can run consecutive scans in one instance.
