var form;

function makeEditable() {
    form = $('#detailsForm');

    form.submit(function () {
        save();
        return false;
    });
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.serialize(),
        success: function () {
            $('#editRow').modal('hide');
            updateTable();
            successNoty('Saved');
        }
    });
}

function successNoty() {
    
}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}