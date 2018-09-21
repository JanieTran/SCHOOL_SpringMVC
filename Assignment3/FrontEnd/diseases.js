var url = `http://ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/`
var listOfDiseases = []
var startIndex = 0
var access_token = ''

$(document).ready(function() {
    access_token = localStorage.getItem('access_token')

    $.ajax ({
        url: `${url}diseases/?access_token=${access_token}`,
        method: 'get',
        success: function(result) {
            listOfDiseases = result
            loadDiseases(startIndex)
        },
        error: function() {
            console.log("Error getting")
            document.location = 'index.html'
        }
    })

    toggleForm()
})

function loadDiseases(startIndex) {
    clearTable()
    if (startIndex + 100 > listOfDiseases.length) {
        var endIndex = listOfDiseases.length
    } else {
        var endIndex = startIndex + 100
    }

    for (var i = startIndex; i < endIndex; i++) {
        var del = `
            <button type="button" class="btn btn-danger" onclick="deleteDisease('${listOfDiseases[i].icd}','${listOfDiseases[i].id}')">Delete</button>
        `
        var newRow = `
            <th scope="row">${listOfDiseases[i].id}</th>
            <td>${listOfDiseases[i].icd}</td>
            <td>${listOfDiseases[i].name}</td>
            <td>${del}</td>
        `
        $('#table_Diseases').append(`<tr id=${listOfDiseases[i].icd}>${newRow}</tr>`)
        $('#resultStatus').text(`Showing ${startIndex} - ${endIndex} of ${listOfDiseases.length} results`)
    }

    if (startIndex + 100 > listOfDiseases.length) {
        document.getElementById('downList').disabled = true
    }

    if (startIndex - 100 < 0) {
        document.getElementById('upList').disabled = true
    }
}

function clearTable() {
    var tableHeaderRowCount = 1;
    var table = document.getElementById('table_Diseases');
    var rowCount = table.rows.length;
    for (var i = tableHeaderRowCount; i < rowCount; i++) {
        table.deleteRow(tableHeaderRowCount);
    }
}

function downList() {
    startIndex += 100
    document.getElementById('upList').disabled = false
    loadDiseases(startIndex)
}

function upList() {
    startIndex -= 100
    document.getElementById('downList').disabled = false
    loadDiseases(startIndex)
}

function deleteDisease(icd, id) {
    if (confirm('Do you want to delete?')) {
        $.ajax({
            url: `${url}del-disease/${id}/?access_token=${access_token}`,
            method: 'delete',
            success: function(result) {
                $('#' + icd).remove()
            }
        })
    }
}

function toggleForm() {
    if ($('#form_addDisease').is(':visible')) {
        $('#form_addDisease').hide()
    } else {
        $('#form_addDisease').show()
    }
}

function addDisease() {
    var inputIcd = $('#input_icd').val()
    var inputName = $('#input_name').val()
    var disease = {'icd': inputIcd, 'name': inputName}

    $.ajax ({
        url: `${url}add-diseases/?access_token=${access_token}`,
        method: 'post',
        contentType: 'application/json',
        data: JSON.stringify(disease),
        success: function(result) {
            console.log(result)
            location.reload()
        }
    })
}

function search() {
    var type = $('#input_type').val()
    var query = $('#input_query').val()

    switch (type) {
        case 'icd':
            $.ajax ({
                url: `${url}diseases-icd/${query}/?access_token=${access_token}`,
                method: 'get',
                success: function(result) {
                    startIndex = 0
                    listOfDiseases = result
                    loadDiseases(startIndex)
                },
                error: function() {
                    console.log("Error getting")
                }
            })
            break;

        case 'name':
            $.ajax ({
                url: `${url}find-disease/${query}/?access_token=${access_token}`,
                method: 'get',
                success: function(result) {
                    startIndex = 0
                    listOfDiseases = result
                    loadDiseases(startIndex)
                },
                error: function() {
                    console.log("Error getting")
                }
            })
            break;
    
        default:
            break;
    }
}