echo "======================"
echo "http://localhost:8762/banquet/api/event/getThemes"
echo "======================"

# -v verbose
curl -v -H 'Access-Control-Request-Method: GET' \
    -H "Content-Type: application/json" \
    -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvbWFyIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTUzODM0MzU4NywiZXhwIjoxNTM4NDI5OTg3fQ.TNTcnT1AXNprq5oCasNGXEMYoE310NO71JV0-PdORyAs95Ig25yMLKK9TmA-9tOF5-FHMCOrhHWrJW7VqVAeDw" \
    "http://localhost:8762/banquet/api/event/getThemes"

echo
