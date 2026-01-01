#!/bin/bash

echo "1st positional arguments related to severity: $1"
echo "2nd positional argument related to exit-code: $2"
echo "3rd positional argument docker image name: $3"


# Generate timestamp for unique filename
TIMESTAMP=$(date +%Y%m%d_%H%M%S)
OUTPUT_FILE=${4:-"trivy-image-$TIMESTAMP.json"}

trivy image \
    --severity "$1" \
    --exit-code "$2" \
    --format json \
    --output "$OUTPUT_FILE" \
    "$3"

echo "Results saved to: $OUTPUT_FILE"