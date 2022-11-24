const add_button = document.getElementById("add_button")
add_button.onclick = () => {
    const speaker = {}
    const new_speaker_form = document.getElementById("new-speaker")
    console.log(Date.now())
    console.log(new_speaker_form)
    console.log(new_speaker_form.children)

    const s = [new_speaker_form]
    const r = {}
    while (s.length !== 0) {
        const t = s[s.length - 1]
        s.pop()
        switch (t.tag) {
            case 'fieldset':
                break
            case 'input':
                break
            case 'label':
                break
        }
    }
}