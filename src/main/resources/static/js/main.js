const addToCartButton = document.querySelector("#add-to-cart");

const productId = addToCartButton.dataset.id;

addToCartButton.addEventListener("click",function (event) {

    fetch("http://localhost:8080/api/products/product/"+productId)

        .then((response) => response.json())

        .then((data) => {

            const product = data;

            let cart;

            if(localStorage.getItem("cart") == null){

                 cart = [];

            }else{

                 cart = JSON.parse(localStorage.getItem("cart"));

            }

            cart.push(product);

            const JSONCart = JSON.stringify(cart)

            localStorage.setItem("cart", JSONCart);

            window.location.replace("http://localhost:8080/home");

        });

} )

