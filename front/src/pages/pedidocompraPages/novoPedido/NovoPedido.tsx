
import SearchLoja from '@/components/SearchLoja';
import Menu from '@/components/Menu';
import DadosNovoPedido from './CriarPedido';
import { useParams } from 'react-router-dom';
// import {useFetch} from '@/lib/hook';


function NovoPedido() {
    const { usernameID } = useParams<{ usernameID?: string }>();
    return (
        <div className="flex">
            <Menu usuarioID={usernameID || ""} />
            <div className="flex flex-col w-full">
                <SearchLoja />
                <div className="flex flex-col h-[92.2vh] bg-[#F5F5F5] justify-center items-center overflow-y-scroll scroll-visible">
                    <div className="flex flex-col w-full h-full justify-center items-center"> 
                        <div className="flex flex-col w-full h-full bg-[#F5F5F5] justify-center items-center">
                          <div className='flex flex-col w-[30vw] h-full'>
                            <div className='flex w-full p-5 mt-10 bg-[#EEEEEE] items-center'>
                            <span className='text-2xl'>Cadastro de Pedido</span> </div>
                            <DadosNovoPedido/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default NovoPedido;
