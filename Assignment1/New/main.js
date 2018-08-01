function chooseDistrict() {
    var dist = $('#district').val()

    switch (dist) {
        case '0':
            $('.d1, .d3, .d5, .d7, .dtb').hide()
            break

        case '1':
            $('.d1, .d3, .d5, .d7, .dtb').hide()
            $('.d1').show()
            break

        case '3':
            $('.d1, .d3, .d5, .d7, .dtb').hide()
            $('.d3').show()
            break

        case '5':
            $('.d1, .d3, .d5, .d7, .dtb').hide()
            $('.d5').show()
            break

        case '7':
            $('.d1, .d3, .d5, .d7, .dtb').hide()
            $('.d7').show()
            break

        case 'TB':
            $('.d1, .d3, .d5, .d7, .dtb').hide()
            $('.dtb').show()
            break
    
        default:
            break
    }
}

function chooseProduct() {
    var product = $('#product').val()

    switch (product) {
        case 'hazelnutcoffee':
        case 'tropicalfruits':
            $('#product-chosen').show()
            $('#product-chosen').attr('src', `img/${product}.png`)
            break

        case '0':
            $('#product-chosen').hide()
            $('#product-chosen').attr('src', '')
            break
    
        default:
            $('#product-chosen').show()
            $('#product-chosen').attr('src', `img/${product}.jpg`)
            break
    }

    calculateTotal()
}

function chooseQuantity() {
    
}

function calculateTotal() {
    var price = 0;
    var quantity = parseInt($('#quantity').val())

    switch ($('#product').val()) {
        case 'rosefoam':
            price = 70000
            break

        case 'oloong':
            price = 35000
            break

        case 'greentea':
        case 'jasmine':
            price = 25000
            break

        case 'tropicalfruits':
        case 'hazelnutcoffee':
            price = 49000
            break
    
        default:
            break
    }

    $('#total').text(price * quantity)
}