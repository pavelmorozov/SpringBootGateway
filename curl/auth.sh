user="omar"
pass="12345"

generate_post_data()
{
cat <<EOF
{
	"username": "$user",
	"password": "$pass"
}
EOF
}

echo $(generate_post_data)

echo "======================"
echo "http://localhost:8060/auth"
echo "======================"

# -v verbose
curl -v -H 'Access-Control-Request-Method: POST' \
    -H "Content-Type: application/json" \
    "http://localhost:8060/auth/" \
    -d "$(generate_post_data)"

echo
