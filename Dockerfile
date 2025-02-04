# Use the official Maven image with OpenJDK 11 as the base image
FROM eclipse-temurin:23

# Install Maven
RUN apt-get update && apt-get install -y maven

# Update the package list and install necessary tools
# RUN apt-get update && apt-get install -y \
#     wget \                # Tool for downloading files
#     unzip \               # Tool for extracting zip files
#     google-chrome-stable  # Install the stable version of Google Chrome
#
# # Download and install ChromeDriver
# RUN wget https://chromedriver.storage.googleapis.com/120.0.6099.109/chromedriver_linux64.zip \
#     && unzip chromedriver_linux64.zip \  # Extract the ChromeDriver zip file
#     && mv chromedriver /usr/local/bin/chromedriver \  # Move ChromeDriver to a directory in the PATH
#     && chmod +x /usr/local/bin/chromedriver  # Make ChromeDriver executable

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files into the container
COPY . .

# Define the default command to run when the container starts
CMD ["mvn", "clean", "test"]