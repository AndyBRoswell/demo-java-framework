const add_button = document.getElementById("add_button")
add_button.onclick = () => {
    const speaker = {}
    const new_speaker_fieldset = document.getElementById("new-speaker")
    console.log(Date.now())

    speaker['model'] = new_speaker_fieldset.querySelector('input[name="model"]').getAttribute('value')
    {
        speaker['type'] = []
        const type_fieldset = new_speaker_fieldset.querySelector('fieldset[name="type"]')
        const checked_checkboxes = type_fieldset.querySelectorAll('input[checked]');
        for (const checkbox of checked_checkboxes) {
            speaker['type'].push(checkbox.getAttribute('name'))
        }
    }
    {
        driver_fieldset = new_speaker_fieldset.querySelector('fieldset[name="driver"]')
        
    }
}