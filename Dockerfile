# Use the official Eclipse Temurin image with OpenJDK 23
FROM eclipse-temurin:23

# Install Maven
RUN apt-get update && apt-get install -y maven

# Install Chrome and ChromeDriver
RUN apt-get install -y wget unzip google-chrome-stable
RUN wget https://chromedriver.storage.googleapis.com/120.0.6099.109/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip \
    && mv chromedriver /usr/local/bin/chromedriver \
    && chmod +x /usr/local/bin/chromedriver

# Set the working directory
WORKDIR /app

# Copy the Maven project files
COPY . .

# Run the tests
CMD ["mvn", "clean", "test"]