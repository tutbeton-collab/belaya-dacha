import Image from 'next/image';

const vegetables = [
  {
    name: 'Томаты',
    description: 'Сочные, мясистые томаты различных сортов. Выращиваем в открытом грунте и теплицах.',
    image: '/images/vegetables/tomatoes.jpg',
    icon: '🍅',
  },
  {
    name: 'Огурцы',
    description: 'Хрустящие огурчики с тонкой кожицей и сладковатым вкусом. Идеальны для салатов и засолки.',
    image: '/images/vegetables/cucumbers.jpg',
    icon: '🥒',
  },
  {
    name: 'Перцы',
    description: 'Сладкие болгарские перцы ярких цветов. Богаты витаминами и обладают насыщенным вкусом.',
    image: '/images/vegetables/peppers.jpg',
    icon: '🫑',
  },
  {
    name: 'Зелень',
    description: 'Ароматная свежая зелень: укроп, петрушка, кинза, базилик. Выращиваем круглый год.',
    image: '/images/vegetables/greens.jpg',
    icon: '🌿',
  },
  {
    name: 'Кабачки',
    description: 'Нежные кабачки для ваших кулинарных шедевров. Выращиваем без химикатов.',
    image: '/images/vegetables/zucchini.jpg',
    icon: '🥒',
  },
  {
    name: 'Сезонные овощи',
    description: 'Кукуруза, морковь, свёкла и другие овощи по сезону.',
    image: '/images/vegetables/corn.jpg',
    icon: '🌽',
  },
];

export default function Vegetables() {
  return (
    <section id="vegetables" className="section bg-farm-cream">
      <div className="container mx-auto px-4">
        <h2 className="section-title">Наши овощи</h2>
        <p className="section-subtitle">
          Выращиваем с любовью, собираем вручную
        </p>

        <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-8 max-w-6xl mx-auto">
          {vegetables.map((veg, index) => (
            <div
              key={veg.name}
              className="card bg-white hover-lift overflow-hidden"
              style={{ animationDelay: `${index * 0.1}s` }}
            >
              <div className="relative h-48 w-full mb-4 rounded-lg overflow-hidden">
                <Image
                  src={veg.image}
                  alt={veg.name}
                  fill
                  className="object-cover"
                />
              </div>
              <h3 className="text-xl font-bold text-farm-green mb-3 flex items-center gap-2">
                <span>{veg.icon}</span>
                {veg.name}
              </h3>
              <p className="text-farm-brown leading-relaxed">{veg.description}</p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
