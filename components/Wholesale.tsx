import Link from 'next/link';

export default function Wholesale() {
  return (
    <section id="wholesale" className="section bg-gradient-to-br from-farm-green to-farm-green-light text-white">
      <div className="container mx-auto px-4">
        <div className="max-w-4xl mx-auto text-center">
          <h2 className="text-3xl md:text-4xl font-bold mb-6">
            Для оптовых партнёров
          </h2>
          <p className="text-xl mb-8 opacity-90 leading-relaxed">
            Приглашаем к сотрудничеству рестораны, кафе, магазины и других партнёров. 
            Мы гарантируем стабильные поставки свежих овощей, гибкие условия сотрудничества 
            и специальные цены для оптовых покупателей.
          </p>
          
          <div className="grid md:grid-cols-3 gap-6 mb-10">
            <div className="bg-white/10 backdrop-blur-sm rounded-xl p-6">
              <div className="text-3xl mb-3">📦</div>
              <h3 className="font-bold mb-2">Стабильные поставки</h3>
              <p className="text-sm opacity-80">Регулярные отгрузки по согласованному графику</p>
            </div>
            <div className="bg-white/10 backdrop-blur-sm rounded-xl p-6">
              <div className="text-3xl mb-3">💰</div>
              <h3 className="font-bold mb-2">Специальные цены</h3>
              <p className="text-sm opacity-80">Выгодные условия для постоянных партнёров</p>
            </div>
            <div className="bg-white/10 backdrop-blur-sm rounded-xl p-6">
              <div className="text-3xl mb-3">✅</div>
              <h3 className="font-bold mb-2">Гарантия качества</h3>
              <p className="text-sm opacity-80">Контроль качества на каждом этапе</p>
            </div>
          </div>
          
          <Link 
            href="#contact" 
            className="inline-block bg-white text-farm-green px-10 py-4 rounded-full font-medium text-lg transition-all duration-300 hover:bg-farm-cream hover:shadow-xl hover:scale-105"
          >
            Обсудить сотрудничество
          </Link>
        </div>
      </div>
    </section>
  );
}
