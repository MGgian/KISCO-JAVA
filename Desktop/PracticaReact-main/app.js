// const { createStore } = require("redux");
const createStore = require('redux').createStore
////// ACTION
const BUY_POKEMON = 'BUY POKEMON';
const buy_pokemon_action = (cant) =>{
    return {
        type: BUY_POKEMON,
        payload: cant
    }
}
////// REDUCER
const default_games_state = {
    pokemon: 10
}
const games_reducer = (state = default_games_state, action) =>{
    switch(action.type) {
        case BUY_POKEMON: {
            return{
                pokemon: state.pokemon - action.payload
            }
        }
        default: return state;
    }
}
////// STORE
const store = createStore(games_reducer);
console.log('estado inical: ', store.getState());

store.subscribe(()=>{
    console.log('cambio de estado ', store.getState())
});

store.dispatch(buy_pokemon_action(3))