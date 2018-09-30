<template>
    <cell-box>
        <div class="i_cell_form_box">
            <div class="i_cell_form_box_item">
                <div class="i_cell_form_box_label">{{leftLabel || ''}}</div>
                <div class="i_cell_form_box_val">{{leftVal || ''}}</div>
            </div>
            <div class="i_cell_form_box_item">
                <div class="i_cell_form_box_label">{{rightLabel || ''}}</div>
                <div class="i_cell_form_box_val">{{rightVal || ''}}</div>
            </div>
        </div>
    </cell-box>
</template>

<script>
import { CellBox } from 'vux'
import 'assets/css/cell_form.css'
export default {
    name: 'i-cell-form',
    components: { CellBox },
    data() {
        return {

        }
    },
    props: ['left-label', 'left-val', 'right-label', 'right-val'],
    mounted() {

    }
}
</script>
