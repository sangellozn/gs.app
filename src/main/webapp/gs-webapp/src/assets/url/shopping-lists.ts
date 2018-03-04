import { environment } from 'environments/environment';

const shoppingListsBase = 'shoppinglists';

const BASE_URL = environment.baseApiUrl + '/' + environment.restUrl + '/' + shoppingListsBase;


export const shoppingListsUrls = {
    create: `$BASE_URL/create`,
    close: `$BASE_URL/close`,
    current: `$BASE_URL/current`
};
