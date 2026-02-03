#!/bin/bash
echo "Stopping application..."
pkill -f 'todo-0.0.1-SNAPSHOT.jar' || true
