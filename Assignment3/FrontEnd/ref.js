$(document).ready(function() {
    // Ajax call to domain
    $.ajax({
        url: 'http://rmit.chickenkiller.com:8080/students',
        method: 'get',
        success: function(result) {
            for (var i = 0; i < result.length; i++) {
                var id = result[i]._id
                var del = `<a href='#' onClick = "onDelete('${id}')">Delete</a>`
                var edit = `<a href='#' onClick = "onEdit('${id}', '${result[i].name}', '${result[i].age}')">Edit</a>`
                var row = 
                    `<tr id = '${id}'>
                        <td>${result[i].name}</td>
                        <td>${result[i].age}</td>
                        <td>${edit} | ${del}</td>
                    </tr>`
                
                $('#tblStudent tbody').append(row)
            }
        }
    })
})

function onDelete(id) {
    if (confirm('Do you want to delete?')) {
        $.ajax({
            url: 'http://rmit.chickenkiller.com:8080/students/' + id,
            method: 'delete',
            success: function(result) {
                $('#' + id).remove()
            }
        })
    }
}

function onSave() {
    var student = {name: $('#name').val(), age: $('#age').val()}
    if ($('#id').val() != '') {
        $.ajax ({
            url: 'http://rmit.chickenkiller.com:8080/students/',
            method: 'post',
            contentType: 'application/json',
            data: JSON.stringify(student),
            success: function(result) {
                console.log(result)
                var id = result._id
                var del = `<a href='#' onClick = "onDelete('${id}')">Delete</a>`
                var row = 
                    `<tr id = '${id}'>
                        <td>${result.name}</td>
                        <td>${result.age}</td>
                        <td>${del}</td>
                    </tr>`
                
                $('#tblStudent tbody').append(row)
                alert('Save successful')
            }
        })
    } else {
        // HOMEWORK: Put method here
    }
    
}

function onEdit(id, name, age) {
    console.log("Edit")
    $('#id').val(id)
    $('#name').val(name)
    $('#age').val(age)
}