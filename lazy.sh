#!/bin/bash
echo "Auto-commit"
git pull
echo ""
echo "Voer commit-message in:"
read input
echo ""
git add .
git commit -m "$input"

git push
echo ""
echo "Done! Fijne dag nog"
