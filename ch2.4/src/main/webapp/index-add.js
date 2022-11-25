const add_button = document.getElementById("add_button")
const return_value_textfield = document.getElementById('return-value')
const return_message_textfield = document.getElementById('return-message')
add_button.onclick = () => {
    const speaker = {}
    const new_speaker_fieldset = document.getElementById("new-speaker")
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
        const driver_fieldsets = new_speaker_fieldset.querySelectorAll('fieldset[name="driver"]>fieldset')
        speaker['driver'] = {}
        for (const fieldset of driver_fieldsets) {
            {
                let no_content = true
                const inputs = fieldset.querySelectorAll('input')
                for (const input of inputs) {
                    if (input.getAttribute('value') !== null) {
                        no_content = false
                        break
                    }
                }
                if (no_content) continue
            }
            const driver_type = fieldset.getAttribute('name')
            const direct_inputs = fieldset.querySelectorAll(':scope>input')
            let target = speaker['driver'][driver_type] = {}
            for (const input of direct_inputs) {
                const value = input.getAttribute('value')
                const unit = input.nextSibling.textContent
                if (!unit) {
                    if (value !== null) target[input.getAttribute('name')] = value
                } else {
                    if (value !== null) target[input.getAttribute('name')] = {
                        value: value, unit: unit
                    }
                }
            }
            const power_fieldset = fieldset.querySelector('fieldset[name="power"]')
            const power_inputs = power_fieldset.querySelectorAll('input')
            target = speaker['driver'][driver_type]['power'] = {}
            for (const input of power_inputs) {
                const value = input.getAttribute('value')
                if (value !== null) target[input.getAttribute('name')] = {
                    value: value, unit: input.nextSibling.textContent
                }
            }
        }
    }
    {
        const frequency_response_fieldset = new_speaker_fieldset.querySelector('fieldset[name="frequency_response"]')
        const dimension_fieldset = new_speaker_fieldset.querySelector('fieldset[name="dimension"]')
        const fieldsets = [ frequency_response_fieldset, dimension_fieldset, ]
        for (const fieldset of fieldsets) {
            const inputs = fieldset.querySelectorAll('input')
            const target = speaker[fieldset.getAttribute('name')] = {}
            for (const input of inputs) {
                const value = input.getAttribute('value')
                const unit = input.nextSibling.textContent
                if (!unit) {
                    if (value !== null) target[input.getAttribute('name')] = value
                } else {
                    if (value !== null) target[input.getAttribute('name')] = {
                        value: value, unit: unit
                    }
                }
            }
        }
    }
    {
        const weight_input = new_speaker_fieldset.querySelector('input[name="weight"]')
        const weight_unit = weight_input.nextSibling.textContent
        speaker['weight'] = {
            value: weight_input.getAttribute('value'), unit: weight_unit
        }
    }
    const json = JSON.stringify(speaker)
    const HTTP_request = new XMLHttpRequest()
    HTTP_request.open('POST', window.location.href + 'add', true)
    HTTP_request.setRequestHeader('Content-type', 'application/json')
    HTTP_request.send(json)
    HTTP_request.onreadystatechange = () => {
        if (HTTP_request.readyState === XMLHttpRequest.DONE) {
            const response = JSON.parse(HTTP_request.responseText)
            return_value_textfield.value = response['ret']
            return_message_textfield.value = response['msg']
        }
    }
}