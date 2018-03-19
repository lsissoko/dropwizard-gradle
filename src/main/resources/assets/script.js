$(document).ready(() => {

  const getResultHtml = (data) => data.map(x => `<li>${x.text}</li>`);

  $.get('/api/tasks', (response) => {
    $('#results').html(getResultHtml(response));
  });

  $('#form-id').submit(function() {
    $.ajax({
      data: $(this).serialize(),
      type: $(this).attr('method'),
      url: $(this).attr('action'),
      success: (response) => {
        $('#results').html(getResultHtml(response));
        $('#task').val('');
      }
    });
    // Stop the page reload
    return false;
  });

  $('#clear').click(() => {
    $.get('/api/tasks/clear', (response) => {
      $('#results').html('');
    });
  })

});
