var ajaxUrl = 'ajax/insurance/';
var datatableApi;

function updateTable() {
    $.ajax({
        type: "POST",
        url: ajaxUrl + 'filterByData',
        data: $('#filterByData').serialize(),
        success: updateTableByData
    });
    return false;    
}

$(function () {
    datatableApi = $('#datatable').DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "content",
                "render": function (data, type, row) {
                    return '<img src="'+data+'">';
                }
            },
            {
                "data": "name"
            },
            {
                "data": "description"
            },
            {
                "data": "franchise"
            },
            {
                "data": "population"
            },
            {
                "data": "engine_power"
            },
            {
                "data": "amount"
            },
            {
                "defaultContent": "",
                "orderable": false,
                "render": renderEditBtn
            },
            {
                "defaultContent": "",
                "orderable": false,
                "render": renderDeleteBtn
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ],
        "initComplete": function () {
        $('#filterByData').submit(function () {
            updateTable();
            return false;
        });
        makeEditable();
    }
    });
});




