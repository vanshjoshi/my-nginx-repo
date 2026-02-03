#!/bin/bash
echo "Starting application..."
cd /home/ec2-user/app
nohup java -jar todo-0.0.1-SNAPSHOT.jar > app.log 2>&1 &
