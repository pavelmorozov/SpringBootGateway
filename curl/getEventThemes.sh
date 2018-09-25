echo "======================"
echo "http://localhost:8060/banquet/api/event/getThemes"
echo "======================"

# -v verbose
curl -v -H 'Access-Control-Request-Method: GET' \
    -H "Content-Type: application/json" \
    "http://localhost:8060/banquet/api/event/getThemes"

echo
