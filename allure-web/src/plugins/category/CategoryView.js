import {View} from 'backbone.marionette';
import template from './CategoryView.hbs';
import {className} from '../../decorators/index';

@className('pane__section')
class SeverityView extends View {
    template = template;

    serializeData() {
        var extra = this.model.get('extra');
        return {
            category: extra ? extra.category : null
        };
    }
}

export default SeverityView;